public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img)
              {
                    xxPos = xP; yyPos = yP; xxVel = xV;
                    yyVel = yV;
                    mass = m;
                    imgFileName = img;
              }
    public Planet(Planet p)
    {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p)
    {
        double Distance = 0;

        Distance = (this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+
        (this.yyPos-p.yyPos)*(this.yyPos-p.yyPos);

        return Math.sqrt(Distance);
    }

    public double calcForceExertedBy(Planet p)
    {
        double F;
        F = G*this.mass*p.mass /(this.calcDistance(p)*this.calcDistance(p));
        return F;
    }

    public double calcForceExertedByX(Planet p)
    {
        double Fx = calcForceExertedBy(p);
        Fx = Fx*(p.xxPos - xxPos) / this.calcDistance(p);
        return Fx;
    }

    public double calcForceExertedByY(Planet p)
    {
        double Fy = calcForceExertedBy(p);
        Fy = Fy*(p.yyPos - yyPos) / this.calcDistance(p);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet []allPlanets)
    {
        double NetFx = 0;
        for(Planet t : allPlanets)
            if(!this.equals(t))
                NetFx += this.calcForceExertedByX(t);

        return NetFx;
    }

    public double calcNetForceExertedByY(Planet []allPlanets)
    {
        double NetFy = 0;
        for(Planet t : allPlanets)
            if(t.imgFileName != this.imgFileName)
                NetFy += this.calcForceExertedByY(t);

        return NetFy;
    }

    public void update(double dt, double fx, double fy)
    {
        double ax = 0, ay = 0;
        ax = fx/mass;
        ay = fy/mass;
        xxVel = ax*dt + xxVel;
        yyVel = ay*dt + yyVel;
        xxPos = xxVel*dt + xxPos;
        yyPos = yyVel*dt + yyPos;
    }

    public void draw()
    {
        StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
    }
}