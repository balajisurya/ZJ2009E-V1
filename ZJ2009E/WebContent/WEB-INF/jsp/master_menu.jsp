<!--left-fixed -navigation-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1" style="overflow: auto;">
				<c:if test="${!empty menulist}">
				<ul class="nav" id="side-menu">
					<c:forEach items="${menulist}" var="menu">
						<li>
							<a href="${pageContext.request.contextPath}${menu.getLink()}"><i class="${menu.getIcon()}"></i>${menu.getMenuName()} <!-- batch icon for mrenu<span class="nav-badge">12</span> --> 
								<c:if test="${menu.getMenuLevel2s().size()>0}">
									<span class="fa arrow"></span>
								</c:if>
							</a>
							<c:if test="${menu.getMenuLevel2s().size()>0}">
								<c:forEach items="${menu.getMenuLevel2s()}" var="submenu">
									<ul class="nav nav-second-level collapse">
										<li>
											<a href="${pageContext.request.contextPath}${submenu.getLink()}">${submenu.getMenuName()}</a>
										</li>
									</ul>
								</c:forEach>
							</c:if>
							
							<!-- /nav-second-level -->
						</li>
						<div class="clearfix"> </div>
					</c:forEach>
					</ul>
				</c:if>
					<!-- //sidebar-collapse -->
					<br>
					<br>
					<br>	
					
				</nav>
			</div>
		</div>