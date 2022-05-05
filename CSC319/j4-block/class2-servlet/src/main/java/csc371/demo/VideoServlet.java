package csc371.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VideoServlet", value = "/VideoServlet")
public class VideoServlet extends HttpServlet {
    private List<Video> videos = new ArrayList<>();
    // Get video information
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter sendToClient = response.getWriter();
        for (Video v : this.videos) {
            sendToClient.write(v.getName() + ": " + v.getUrl() + "\n");
        }
    }

    // Add a new video information
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vidName = request.getParameter("name");
        String vidUrl = request.getParameter("url");
        String durationString = request.getParameter("duration");
        long vidDuration = 0;

        if (vidName == null || vidUrl == null || durationString == null
        || vidName.trim().length() < 1 || vidUrl.trim().length() < 1 || durationString.trim().length() < 1) {
            response.sendError(400, "Missing ['name', 'url', 'duration']");
            return;
        }

        try {
            vidDuration = Long.parseLong(durationString);
            if (vidDuration <= 0) throw  new Exception();
        } catch (Exception e) {
            response.sendError(400, "Illegal format of duration");
            return;
        }

        videos.add(new Video(vidName, vidUrl, vidDuration));
        PrintWriter sendToClient = response.getWriter();
        sendToClient.write("VIDEO ADDED!");
    }

}
