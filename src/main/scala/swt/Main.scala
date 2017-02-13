package swt

import org.eclipse.swt._
import org.eclipse.swt.layout._
import org.eclipse.swt.widgets._
import org.eclipse.swt.graphics._
import org.eclipse.swt.events.{Event,PaintEvent,PaintListener}

object Main{
  val display = new Display
  implicit val shell = new Shell(display)

  def main(args:Array[String]) ={
    shell.setLayout(new GridLayout())
    //  shell.pack
    // start
    table
    shell.open
    while (!shell.isDisposed) {
      if (!display.readAndDispatch)
      display.sleep
    }
    display.dispose
  }
  def start()={
    val sc = new ScalaCanvas()
    sc.create
  }
  def table(){
    val table:Table = new Table(shell, SWT.MULTI)
    val button:Button = new Button(shell,SWT.PUSH)
    button.setText("Kliknij!")
    button.addSelectionListener(SWT.Selection, 
        new Listener(){
          override def handleEvent(e:Event)= {
            e match {
              case SWT.Selection => println("!!!")
              case _ => println("coś innego")
            }
          }
        })
	table.setLinesVisible(true)
    for(i <- 1 to 10) new TableItem(table, SWT.NONE).setText("item" + i)
  }
}

class ScalaCanvas{
  def create(implicit shell:Shell)={
    val red:Color = shell.getDisplay.getSystemColor(SWT.COLOR_RED);
      shell.addPaintListener(
      new PaintListener() {
        override def paintControl(e:PaintEvent)={
          e.gc.setBackground(red)
          e.gc.fillOval(5, 5, 100, 100)
        }
      }) 
    val clientArea:Rectangle = shell.getClientArea
    shell.setBounds(clientArea.x + 10, clientArea.y + 10, 200, 200)
  }
}
