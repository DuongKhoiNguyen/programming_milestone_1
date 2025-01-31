package app;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


public class App {

    public static final int         JAVALIN_PORT    = 7000;
    public static final String      CSS_DIR         = "css/";
    // public static final String      IMAGES_DIR      = "images/";
    public static void main(String[] args) {
        // JDBCConnection jdbc = new JDBCConnection();
        // ArrayList<Member> members = jdbc.getMembers();
        // for (Member member : members) {
        //     System.out.println("\t" + member.getName() + ": " + member.getStudentId());
        // }

        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes")); 
            config.addStaticFiles(CSS_DIR);
            // config.addStaticFiles(IMAGES_DIR);
        }).start(JAVALIN_PORT);

        configureRoutes(app);
    }

    public static void configureRoutes(Javalin app) {
        
        
        // ADD ALL OF YOUR WEBPAGES with GET Method HERE
        app.get("/", new PageIndex());
        app.get("/about-us", new PageAboutUs());
        app.get("/dashboard", new PageDashboard());
        app.get("/news", new PageNews());
        app.get("/contact", new PageContact());

     

        // POST pages can accept form data
        
    }
}