import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.graphics.Path;
import java.util.LinkedList;

public class bugex {
	Display d;

	Shell s;

	bugex() {
		d = new Display();
		s = new Shell(d);
		s.setSize(400, 400);

		s.setText("I hope you can fix it :-)   ,.  hello from Sweden and thanks in advance");

		s.setLayout(new FillLayout());

		// Create a canvas to draw on
		Canvas canvas = new Canvas(s, SWT.NONE);

		// Add a handler to do the drawing
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				// Get the canvas and its size
				Canvas canvas = (Canvas) e.widget;
				
				
				// Set the drawing color to blue
				e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLUE));

				// Set the width of the lines to draw
				e.gc.setLineWidth(3);

				
		        int maxX = canvas.getSize().x;
		        int maxY = canvas.getSize().y;

		        // Calculate the middle
		        int halfX = (int) maxX / 2;
		        int halfY = (int) maxY / 2;
				
		     // Draw a horizontal line halfway down the canvas
		        e.gc.drawLine(0, 100, maxX, 100);
		     // Draw a horizontal line halfway down the canvas
		        e.gc.drawLine(0, 500, maxX, 500);
				
				
				
				float x=0;
				float y=0;
				
					

				
				LinkedList xy1 = new LinkedList();
				for(int i =0;i<20000;i++){
					y=(float)Math.round(200*(float)Math.sin((double)i/2)+300);
					//y=(float)Math.round(0.0001*i);
					x=(float)Math.round(i*2);

					xy1.add(new Integer ( (int)x )  );
					xy1.add(new Integer ( (int)y )  );
					


				}


				//e.gc.drawPath(p);
				System.out.println(xy1.size() );
				int[] xyv= new int[xy1.size() ];
				for(int i =0;i<xy1.size();i++){
					xyv[i]=((Integer)xy1.get(i)).intValue();

					//System.out.println(xv[k]);
					//System.out.println(xv[k]);


				}

				e.gc.drawPolyline(xyv);



			}
		});



		s.open();

		while (!s.isDisposed()) {
			if (!d.readAndDispatch())
				d.sleep();
		}
		d.dispose();
	}

	public static void main(String[] argv) {
		new bugex();
	}

}