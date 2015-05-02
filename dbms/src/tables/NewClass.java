
SpringUtilities.java
001 /*
002  * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
003  *
004  * Redistribution and use in source and binary forms, with or without
005  * modification, are permitted provided that the following conditions
006  * are met:
007  *
008  *   - Redistributions of source code must retain the above copyright
009  *     notice, this list of conditions and the following disclaimer.
010  *
011  *   - Redistributions in binary form must reproduce the above copyright
012  *     notice, this list of conditions and the following disclaimer in the
013  *     documentation and/or other materials provided with the distribution.
014  *
015  *   - Neither the name of Oracle or the names of its
016  *     contributors may be used to endorse or promote products derived
017  *     from this software without specific prior written permission.
018  *
019  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
020  * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
021  * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
022  * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
023  * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
024  * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
025  * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
026  * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
027  * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
028  * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
029  * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
030  */ 
031 
032package tables;
033 
034 import javax.swing.*;
035 import javax.swing.SpringLayout;
036 import java.awt.*;
037 
038 /**
039  * A 1.4 file that provides utility methods for
040  * creating form- or grid-style layouts with SpringLayout.
041  * These utilities are used by several programs, such as
042  * SpringBox and SpringCompactGrid.
043  */
044 public class SpringUtilities {
045     /**
046      * A debugging utility that prints to stdout the component's
047      * minimum, preferred, and maximum sizes.
048      */
049     public static void printSizes(Component c) {
050         System.out.println("minimumSize = " + c.getMinimumSize());
051         System.out.println("preferredSize = " + c.getPreferredSize());
052         System.out.println("maximumSize = " + c.getMaximumSize());
053     }
054 
055     /**
056      * Aligns the first <code>rows</code> * <code>cols</code>
057      * components of <code>parent</code> in
058      * a grid. Each component is as big as the maximum
059      * preferred width and height of the components.
060      * The parent is made just big enough to fit them all.
061      *
062      * @param rows number of rows
063      * @param cols number of columns
064      * @param initialX x location to start the grid at
065      * @param initialY y location to start the grid at
066      * @param xPad x padding between cells
067      * @param yPad y padding between cells
068      */
069     public static void makeGrid(Container parent,
070                                 int rows, int cols,
071                                 int initialX, int initialY,
072                                 int xPad, int yPad) {
073         SpringLayout layout;
074         try {
075             layout = (SpringLayout)parent.getLayout();
076         } catch (ClassCastException exc) {
077             System.err.println("The first argument to makeGrid must use SpringLayout.");
078             return;
079         }
080 
081         Spring xPadSpring = Spring.constant(xPad);
082         Spring yPadSpring = Spring.constant(yPad);
083         Spring initialXSpring = Spring.constant(initialX);
084         Spring initialYSpring = Spring.constant(initialY);
085         int max = rows * cols;
086 
087         //Calculate Springs that are the max of the width/height so that all
088         //cells have the same size.
089         Spring maxWidthSpring = layout.getConstraints(parent.getComponent(0)).
090                                     getWidth();
091         Spring maxHeightSpring = layout.getConstraints(parent.getComponent(0)).
092                                     getHeight();
093         for (int i = 1; i < max; i++) {
094             SpringLayout.Constraints cons = layout.getConstraints(
095                                             parent.getComponent(i));
096 
097             maxWidthSpring = Spring.max(maxWidthSpring, cons.getWidth());
098             maxHeightSpring = Spring.max(maxHeightSpring, cons.getHeight());
099         }
100 
101         //Apply the new width/height Spring. This forces all the
102         //components to have the same size.
103         for (int i = 0; i < max; i++) {
104             SpringLayout.Constraints cons = layout.getConstraints(
105                                             parent.getComponent(i));
106 
107             cons.setWidth(maxWidthSpring);
108             cons.setHeight(maxHeightSpring);
109         }
110 
111         //Then adjust the x/y constraints of all the cells so that they
112         //are aligned in a grid.
113         SpringLayout.Constraints lastCons = null;
114         SpringLayout.Constraints lastRowCons = null;
115         for (int i = 0; i < max; i++) {
116             SpringLayout.Constraints cons = layout.getConstraints(
117                                                  parent.getComponent(i));
118             if (i % cols == 0) { //start of new row
119                 lastRowCons = lastCons;
120                 cons.setX(initialXSpring);
121             } else { //x position depends on previous component
122                 cons.setX(Spring.sum(lastCons.getConstraint(SpringLayout.EAST),
123                                      xPadSpring));
124             }
125 
126             if (i / cols == 0) { //first row
127                 cons.setY(initialYSpring);
128             } else { //y position depends on previous row
129                 cons.setY(Spring.sum(lastRowCons.getConstraint(SpringLayout.SOUTH),
130                                      yPadSpring));
131             }
132             lastCons = cons;
133         }
134 
135         //Set the parent's size.
136         SpringLayout.Constraints pCons = layout.getConstraints(parent);
137         pCons.setConstraint(SpringLayout.SOUTH,
138                             Spring.sum(
139                                 Spring.constant(yPad),
140                                 lastCons.getConstraint(SpringLayout.SOUTH)));
141         pCons.setConstraint(SpringLayout.EAST,
142                             Spring.sum(
143                                 Spring.constant(xPad),
144                                 lastCons.getConstraint(SpringLayout.EAST)));
145     }
146 
147     /* Used by makeCompactGrid. */
148     private static SpringLayout.Constraints getConstraintsForCell(
149                                                 int row, int col,
150                                                 Container parent,
151                                                 int cols) {
152         SpringLayout layout = (SpringLayout) parent.getLayout();
153         Component c = parent.getComponent(row * cols + col);
154         return layout.getConstraints(c);
155     }
156 
157     /**
158      * Aligns the first <code>rows</code> * <code>cols</code>
159      * components of <code>parent</code> in
160      * a grid. Each component in a column is as wide as the maximum
161      * preferred width of the components in that column;
162      * height is similarly determined for each row.
163      * The parent is made just big enough to fit them all.
164      *
165      * @param rows number of rows
166      * @param cols number of columns
167      * @param initialX x location to start the grid at
168      * @param initialY y location to start the grid at
169      * @param xPad x padding between cells
170      * @param yPad y padding between cells
171      */
172     public static void makeCompactGrid(Container parent,
173                                        int rows, int cols,
174                                        int initialX, int initialY,
175                                        int xPad, int yPad) {
176         SpringLayout layout;
177         try {
178             layout = (SpringLayout)parent.getLayout();
179         } catch (ClassCastException exc) {
180             System.err.println("The first argument to makeCompactGrid must use SpringLayout.");
181             return;
182         }
183 
184         //Align all cells in each column and make them the same width.
185         Spring x = Spring.constant(initialX);
186         for (int c = 0; c < cols; c++) {
187             Spring width = Spring.constant(0);
188             for (int r = 0; r < rows; r++) {
189                 width = Spring.max(width,
190                                    getConstraintsForCell(r, c, parent, cols).
191                                        getWidth());
192             }
193             for (int r = 0; r < rows; r++) {
194                 SpringLayout.Constraints constraints =
195                         getConstraintsForCell(r, c, parent, cols);
196                 constraints.setX(x);
197                 constraints.setWidth(width);
198             }
199             x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
200         }
201 
202         //Align all cells in each row and make them the same height.
203         Spring y = Spring.constant(initialY);
204         for (int r = 0; r < rows; r++) {
205             Spring height = Spring.constant(0);
206             for (int c = 0; c < cols; c++) {
207                 height = Spring.max(height,
208                                     getConstraintsForCell(r, c, parent, cols).
209                                         getHeight());
210             }
211             for (int c = 0; c < cols; c++) {
212                 SpringLayout.Constraints constraints =
213                         getConstraintsForCell(r, c, parent, cols);
214                 constraints.setY(y);
215                 constraints.setHeight(height);
216             }
217             y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
218         }
219 
220         //Set the parent's size.
221         SpringLayout.Constraints pCons = layout.getConstraints(parent);
222         pCons.setConstraint(SpringLayout.SOUTH, y);
223         pCons.setConstraint(SpringLayout.EAST, x);
224     }
225 }