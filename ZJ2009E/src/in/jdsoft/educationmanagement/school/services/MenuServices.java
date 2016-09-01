package in.jdsoft.educationmanagement.school.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jdsoft.educationmanagement.school.dao.MenuLevel1DAO;
import in.jdsoft.educationmanagement.school.dao.MenuLevel2DAO;
import in.jdsoft.educationmanagement.school.model.MenuLevel1;
import in.jdsoft.educationmanagement.school.model.MenuLevel2;




@Service
public class MenuServices {
	
	@Autowired
	MenuLevel1DAO menulevel1dao;
	@Autowired
	MenuLevel2DAO menuLevel2dao;
	
	
	@Transactional
	public ArrayList<MenuLevel1> getMenuList(String userType){
			ArrayList<MenuLevel1> sortedMenu=new ArrayList<>();
			ArrayList<MenuLevel1> menuLevel1s= (ArrayList<MenuLevel1>) menulevel1dao.getList();
			ArrayList<MenuLevel1> validMenuLevel1s= new ArrayList<MenuLevel1>();
			//getting valid MenuLevel1 Based On UserType
			for(MenuLevel1 menuLevel1:menuLevel1s){
				if(menuLevel1.getUserType().contains(userType)){
					validMenuLevel1s.add(menuLevel1);
				}
			}
			
			//Sorting the Valid(based on usertype) MenulLevel1 Based On Order No
			Collections.sort(validMenuLevel1s,new Comparator<MenuLevel1>() {
				@Override
				public int compare(MenuLevel1 o1, MenuLevel1 o2) {
					return o1.getOrderNo().compareTo(o2.getOrderNo());
				}
			 });
			
			//looping all menulevel2 for valid menulevel1,here menulevel two is not validated
			for(MenuLevel1 validmenuLevel1:validMenuLevel1s){
				Set<MenuLevel2> menuLevel2s= validmenuLevel1.getMenuLevel2s();
				 Iterator<MenuLevel2> iterator=menuLevel2s.iterator();
				 	//getting valid MenuLevel2 Based On UserType
				 while(iterator.hasNext()){
					 if(!iterator.next().getUserType().contains(userType)){
						 iterator.remove();
					 }
				 }
				
				//Converting Set<MenuLevel2> to ArrayList<MenuLevel2> so i can sort it
				 List<MenuLevel2> menuLevel2list=new ArrayList<MenuLevel2>(menuLevel2s);
				//Sorting the Valid(based on usertype) MenulLevel2 Based On Order No
				 Collections.sort(menuLevel2list,new Comparator<MenuLevel2>() {
					 @Override
					public int compare(MenuLevel2 o1, MenuLevel2 o2) {
						 return o1.getOrderNo().compareTo(o2.getOrderNo());
					}
				});
				 Set<MenuLevel2> menuLevel2Set=new LinkedHashSet<>(menuLevel2list);
				 validmenuLevel1.setMenuLevel2s(menuLevel2Set);
				 sortedMenu.add(validmenuLevel1);
			}
				return sortedMenu;
					
	}
}

