<!DOCTYPE HTML>
<html>
   <head>
      <title>EMS</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <!-- Bootstrap Core CSS -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/bootstrap.css" rel='stylesheet' type='text/css' />
      <!-- Custom CSS -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/style.css" rel='stylesheet' type='text/css' />
      <!-- font CSS -->
      <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
      <!-- font-awesome icons -->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/font-awesome.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/jqvmap.css" rel='stylesheet' type='text/css' />
      <!-- //font-awesome icons -->
      <!-- js-->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery-1.11.1.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/modernizr.custom.js"></script>
      <!--webfonts-->
      <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
      <!--//webfonts--> 
      <!--animate-->
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/animate.css" rel="stylesheet" type="text/css" media="all">
      
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/wow.min.js"></script>
      
      <script>
         new WOW().init();
      </script>
      <!--//end-animate-->
      <!-- Metis Menu -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/metisMenu.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/custom.js"></script>
      <link href="${pageContext.request.contextPath}/resources/${theme}/css/custom.css" rel="stylesheet">
      <!-- chart -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/Chart.js"></script>
      <script src="${pageContext.request.contextPath}/resources/themes/js/formHide.js"></script> 
       

      
     <style type="text/css">
     
     #logo {
  float: left;
  margin-top: 10px;
   
}

#logo img {
  height: 100px;
}
     
     header {
  padding: 5px 0;
  
  margin-bottom: 20px;
  border-bottom: 1px solid #AAAAAA;
}
     #company {
     margin-top: 15px;
  float: right;
  text-align: right;
}
#details {
  margin-bottom: 50px;
}

#client {
  padding-left: 6px;
  border-left: 6px solid #0087C3;
  float: left;
}

#client .to {
  color: #777777;
}

h2.name {
  font-size: 1.4em;
  font-weight: normal;
  margin: 0;
}

#invoice {
  float: right;
  text-align: right;
}

#invoice h1 {
  color: #0087C3;
  font-size: 2.4em;
  line-height: 1em;
  font-weight: normal;
  margin: 0  0 10px 0;
}

#invoice .date {
  font-size: 1.1em;
  color: #777777;
}
table {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 2px;
  margin-bottom: 20px;
  margin-top: -30px;
  margin-left: 0px;
    margin-right: auto;
  
}

table th,
table td {
  padding: 20px;
  background: #EEEEEE;
  text-align: center;
  border-bottom: 1px solid #FFFFFF;
}

table th {
  white-space: nowrap;        
  font-weight: normal;
}

table td {
  text-align: right;
}

table td h3{
  color: #57B223;
  font-size: 1.2em;
  font-weight: normal;
  margin: 0 0 0.2em 0;
}

table .no {
  color: #FFFFFF;
  font-size: 1.6em;
  background: #57B223;
}

table .desc {
  text-align:center;
}

table .unit {
  background: #DDDDDD;
}

table .qty {
}

table .total {
  background: #57B223;
  color: #FFFFFF;
}

table td.unit,
table td.qty,
table td.total {
  font-size: 1.2em;
}

table tbody tr:last-child td {
  border: none;
}

table tfoot td {
  margin-left:100px;
  padding: 10px 10px;
  background: #FFFFFF;
  border-bottom: none;
  font-size: 1.2em;
  white-space: nowrap; 
  border-top: 1px solid #AAAAAA; 
}

table tfoot tr:first-child td {
  border-top: none; 
}

table tfoot tr:last-child td {
  color: #57B223;
  font-size: 1.4em;
  border-top: 1px solid #57B223; 

}

table tfoot tr td:first-child {
  border: none;
}
     </style>
   </head>
   <%@ include file="master_menu.jsp" %>
   <%@ include file="master_header.jsp" %>
   <body class="cbp-spmenu-push">
      <!-- main content start-->
      <div id="page-wrapper">
         <div class="main-page">
         <header class="clearfix">
         
        <div id="logo">
        <img src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png">
      </div>
            <div id="company">
        
        <div>455 Foggy Heights, AZ 85004, US</div>
        <div>(602) 519-0450</div>
        <div><a href="mailto:company@example.com">company@example.com</a></div>
      </div>
       </header>
         <div >
         
         <div id="details" class="clearfix">
        <div id="client">
          <div class="to">INVOICE TO:</div>
          <h2 class="name">John Doe</h2>
         <label  class="to">Register No:42584955</label>
         
        </div>
        <div id="invoice">
          <h4>INVOICE: 3-2-1</h4>
          <div class="date">Date of Invoice: 01/06/2014</div>
          <div class="date">Due Date: 30/06/2014</div>
        </div>
      </div>
         
         
         
         </div>
         
        
        
         
         
         <table >
        <thead>
          <tr>
            <th style="width: 100px"class="no">S.NO</th>
            <th class="desc" style="width:1000px">FEE DESCRIPTION</th>
           
            <th style="width: 200px"class="total">TOTAL</th>
            
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="no">01</td>
            <td style="text-align: left">Exam Fees</td>
           
            <td class="total">1,200.00</td>
          </tr>
          <tr>
            <td class="no">02</td>
            <td style="text-align: left">Placement Fees</td>
            
            <td class="total">3,200.00</td>
          </tr>
          <tr>
            <td class="no">03</td>
            <td style="text-align: left">Tution Fees</td>
            
            <td class="total">800.00</td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
          
            <td ></td>
            <td style="border: none">SUBTOTAL</td>
            <td>5,200.00</td>
          </tr>
          <tr>
            <td></td>
            <td style="border: none">Discount 25%</td>
            <td>1,300.00</td>
          </tr>
          <tr>
            <td></td>
            <td style="border: none">GRAND TOTAL</td>
            <td>$6,500.00</td>
          </tr>
        </tfoot>
      </table>
            <div class="row">
                                 <div class="col-sm-offset-3">
                                    <button style="float:right"  type="button" id="pri"class="btn btn-success">Print Invoice</button>
                                 
                                                                     </div>
                              </div>
          
         </div>
         
         
      
         
         
         
         
         </div>
        
         
      
       
     
      
      
      <!-- Bootstrap Core JavaScript -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/bootstrap.js"> </script>
      
             <script src="${pageContext.request.contextPath}/resources/themes/js/jscustom.js" type="text/javascript"></script>
       <!-- Classie -->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/classie.js"></script>
     <script type="text/javascript">
     
     
     
     </script>
      <!--scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/jquery.nicescroll.js"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/scripts.js"></script>
      
      <!--//scrolling js-->
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/underscore-min.js" type="text/javascript"></script>
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/moment-2.2.1.js" type="text/javascript"></script>
    
      <script src="${pageContext.request.contextPath}/resources/${theme}/js/site.js" type="text/javascript"></script>
   </body>
</html>