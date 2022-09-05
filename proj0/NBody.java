public class NBody {
    public static void main(String []args)
    {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        String BG = "./images/starfield.jpg";
        double Radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int N = planets.length;
        StdDraw.setScale(-Radius, Radius);

        StdDraw.enableDoubleBuffering();

        // StdDraw.clear();
        // StdDraw.picture(0, 0, BG);
        // StdDraw.show();
        // for(Planet t : planets){
        //     t.draw();
        // }

        double timer = 0;
        for(; timer <= T; timer += dt)
        {
            double[] xForces = new double[N], yForces = new double[N];
            for(int i = 0; i < N; i ++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0; i < N; i ++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // StdDraw.clear();
            StdDraw.picture(0, 0, BG);
            
            for(Planet t : planets){
                t.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
    
    public static double readRadius(String acess)
    {
        In in = new In(acess);
        int N = in.readInt();
		double Radius = in.readDouble();
        return Radius;
    }

    public static Planet[] readPlanets(String acess)
    {
        In in = new In(acess);
        int N = in.readInt();
		double Radius = in.readDouble();
        Planet[] array = new Planet[N];

        for(int i = 0; i < N; i ++){
            double xp, yp, xv, yv, m;
            String file;
            xp = in.readDouble();
            yp = in.readDouble();
            xv = in.readDouble();
            yv = in.readDouble();
            m = in.readDouble();
            file = in.readString();
            array[i] = new Planet(xp, yp, xv, yv, m, file);
        }
        return array;
    }
}
