package nSim;

import java.util.ArrayList;

public class VerletIntegrator implements Integrator {



	@Override
	public void step(PhysicsObject phys,  double dt) {
		// TODO Auto-generated method stub
		Vector3d pos=phys.position;
		Vector3d vel=phys.velocity;
		pos.add(vel.x*dt/2,vel.y*dt/2,vel.z*dt/2);
		Vector3d acc=phys.getAcc();
		
		vel.add(acc.multiply(dt,dt,dt));
		//System.out.println(acc);
		pos.add(vel.x*dt/2,vel.y*dt/2,vel.z*dt/2);
		
		
		
		
	}

}
