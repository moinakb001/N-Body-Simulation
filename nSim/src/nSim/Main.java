package nSim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
final static double au=149597870700.0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Integrator inte=new ForestRuthIntegrator();
		//inte=new EulerIntegrator();
		//inte=new VerletIntegrator();
		
		PhysicsObject[] objs=new PhysicsObject[9];
		for (int i = 0; i <9; i++) {
			double j=i;
			objs[i]=new PhysicsObject(1e30, 0, inte);
			objs[i].position=new Vector3d(au*.5*(4-j), 0);
			objs[i].velocity=new Vector3d(0, 30e3/(4-j));
			if(j==4){
				objs[i].velocity=new Vector3d(0, 0);
			}
			System.out.println(objs[i].position+"   "+objs[i].velocity);
			
			objs[i].addInteraction(new GravFunction());
		}
		
		World w=new World(objs);
		double count=0;
		JFrame f=new JFrame("N Body Simulation");
		JPanel base=new JPanel();
		JPanel pan=new JPanel();
		
		JButton b=new JButton("Do stuff");
		base.add(b);
		pan.setSize(800, 800);
		base.add(pan);
		f.add(base);
		f.pack();
		f.setVisible(true);
		f.setSize(1000, 1000);
		double t_step=1;
		while(true){
			
			w.update(t_step);
			count+=t_step;
			if(count>=10000){
				Graphics g=f.getGraphics();
				ArrayList<PhysicsObject> obs=w.objects;
				//g.clearRect(0, 0, 1000, 1000);
				double xdelt=objs[6].position.x;
				double ydelt=objs[6].position.y;
				for (int i = 0; i < obs.size(); i++) {
					int xpos=(int) ((obs.get(i).position.x-xdelt)*50/au)+500;
					int ypos=(int) ((obs.get(i).position.y-ydelt)*50/au)+500;
					//System.out.println(xpos);
					
					obs.get(i).draw(g, new Vector3d(xpos, ypos));
					count=0;
					
				}
				//g.drawArc(500-(int)(20*5.204267), 500-(int)(20*5.204267), (int)(40*5.204267), (int)(40*5.204267), 0, 360);
				//Thread.sleep(1);
			}
		}
	}
	
	

}
