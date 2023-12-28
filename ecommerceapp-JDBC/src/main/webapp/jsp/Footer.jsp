
<%
    int visitors = 0;

    if(application.getAttribute("visitorCount") == null){
        application.setAttribute("visitorCount", 1);
    } else{
        visitors = (Integer)application.getAttribute("visitorCount");
        visitors++;
        application.setAttribute("visitorCount", visitors);
    }   
%>


<div>
    <hr>
    <center>
        Help | FAQS | Copyright policy
        <br>
        @ Copyrights C-DAC
        <br>
        Developed by DAC team
    </center>

    <p>
        Visitors: <%= application.getAttribute("visitorCount") %>
    </p>
</div>