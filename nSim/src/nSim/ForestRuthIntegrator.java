package nSim;

public class ForestRuthIntegrator implements Integrator {
	final double ksi = 0.1786178958448091;
	final double lamb = -0.2123418310626054;
	double chi = -0.6626458266981849E-01;

	@Override
	public void step(PhysicsObject phys, double dt) {
		// TODO Auto-generated method stub
		Vector3d pos = phys.position;
		Vector3d vel = phys.velocity;

		pos = pos.add(vel.x * dt * ksi, vel.y * dt * ksi, vel.z * dt * ksi);

		Vector3d acc = phys.getAcc();
		double constant = (1 - 2 * lamb) * (dt / 2);
		vel.add(acc.multiply(constant, constant, constant));

		pos = pos.add(vel.x * dt * chi, vel.y * dt * chi, vel.z * dt * chi);

		acc = phys.getAcc();
		constant = (lamb) * (dt);
		vel.add(acc.multiply(constant, constant, constant));

		constant = dt * (1 - 2 * (ksi + chi));
		pos = pos.add(vel.x * dt * constant, vel.y * dt * constant, vel.z * dt
				* constant);

		acc = phys.getAcc();
		constant = (lamb) * (dt);
		vel.add(acc.multiply(constant, constant, constant));

		pos = pos.add(vel.x * dt * chi, vel.y * dt * chi, vel.z * dt * chi);

		acc = phys.getAcc();
		constant = (1 - 2 * lamb) * (dt / 2);
		vel.add(acc.multiply(constant, constant, constant));
		
		pos = pos.add(vel.x * dt * ksi, vel.y * dt * ksi, vel.z * dt * ksi);
		// System.out.println(acc);
		pos.add(vel.x * dt, vel.y * dt, vel.z * dt);

	}

}
