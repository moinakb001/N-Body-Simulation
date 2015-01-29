package nSim;

import java.util.ArrayList;

public class EulerIntegrator implements Integrator {



	@Override
	public void step(PhysicsObject phys,  double dt) {
		// TODO Auto-generated method stub
		Vector3d pos=phys.position;
		Vector3d vel=phys.velocity;
		
		Vector3d acc=phys.getAcc();
		
		vel.add(acc.multiply(dt,dt,dt));
		//System.out.println(acc);
		pos.add(vel.x*dt,vel.y*dt,vel.z*dt);
		
		
		
		
	}

}
