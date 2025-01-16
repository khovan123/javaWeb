<form method="get">
    Enter n: <input type="number" name="quantity"/><br/>
    <input type="submit" name="bt" value="Generated"/><br/>
    <%
    String s = request.getParameter("quantity");
    if(s!=null){
        try{
            int n = Integer.parseInt(s);
            for(int i = 0;i<n;i++){
                out.print("<b>"+i+"</b><br/>");
                }
        } catch(Exception e){
            out.print("<b>Enter n again!!!</b>"); 
        }
        } else{
            out.print("<b>Enter n again!!!</b>");
        }
    %>
</form>