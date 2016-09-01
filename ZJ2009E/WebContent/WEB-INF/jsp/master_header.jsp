<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo" style="width:90xp;">
					<a href="">
						
									<span class="prfil-img"><img src="${pageContext.request.contextPath}${logo}"  width="50" height="50" alt="file"> </span> 
					
					</a>
				</div>
				
					<div class="clearfix"> </div>
				</div>
				<!--notification menu end -->
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
								<span class="prfil-img">
								<img class="img-circle" src="${pageContext.request.contextPath}/resources/themes/images/${profile}" alt="" width="50" height="50"> </span> 
									<div class="user-name">
										<h5><c:out value="${name}"></c:out></h5>
										<span><c:out value="${type}"></c:out></span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu">
								 
								<li> <a id="logout" href="${pageContext.request.contextPath}/authenticate/logout"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>	
			</div>
			<div class="clearfix"> </div>	
		
	
		
            
		<!-- //header-ends -->