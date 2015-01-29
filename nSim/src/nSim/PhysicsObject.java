package nSim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PhysicsObject {
	double mass = 0, charge = 0;
	Vector3d position;
	Vector3d velocity;
	ArrayList<Function> interactions;
	World world;
	Integrator integ;
	double radius;
	Color c=Color.black;

	// World w;
	public PhysicsObject(double mass, double charge, Integrator integ, World world) {
		this.mass = mass;
		this.charge = charge;
		interactions = new ArrayList<Function>();
		this.integ = integ;
		this.world=world;
	}
	public PhysicsObject(double mass, double charge, Integrator integ) {
		this.mass = mass;
		this.charge = charge;
		interactions = new ArrayList<Function>();
		this.integ = integ;
		this.world=null;
	}
	public void addInteraction(Function f) {
		interactions.add(f);
	}

	public void update( double dt) {
		
		integ.step(this, dt);

	}
	public  Vector3d getAcc(){
		Vector3d acc = new Vector3d(0, 0, 0);
		for (int j = 0; j < world.objects.size(); j++) {
			
		PhysicsObject other=world.objects.get(j);
		if(!other.equals(this)){
		for (int i = 0; i < interactions.size(); i++) {
			acc.add(interactions.get(i).getFunction(this, other));
		}
		}
		
		}
		return acc;
	}
	public void draw(Graphics g, Vector3d location) {
		g.setColor(c);
		g.fillRect((int)location.x-1, (int)location.y-1, 3, 3);
		
	}

}
