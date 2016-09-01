package in.jdsoft.educationmanagement.school.dao;
// Generated Mar 29, 2016 2:42:25 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import in.jdsoft.educationmanagement.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentStatus;


@Repository
public class StudentDAO extends GenericDAO<Student> {

	public StudentDAO() {
		super(Student.class);
	}
	
	public Student getStudentById(java.lang.Integer id) {
		try {
			Student instance = (Student) sessionFactory.getCurrentSession()
					.get("in.jdsoft.educationmanagement.school.model.Student", id);
			if (instance == null) {
				//logging
			} else {
				//logging
			}
			return instance;
		} catch (Exception re) {
			throw re;
		}
	}
	
	public Student getStudentByAdmissionNo(String admissionNo) {
		try {
			Criteria studentCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			studentCriteria.add(Restrictions.eq("admissionNo", admissionNo));
			Student student=(Student)studentCriteria.uniqueResult();
			if (student == null) {
				//logging
			} else {
				//logging
			}
			return student;
		} catch (Exception re) {
			throw re;
		}
	}
	
	
	public Student getActiveStudentByAdmissionNo(String admissionNo,StudentStatus studentStatus) {
		try {
			Criteria studentCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			studentCriteria.add(Restrictions.conjunction()
					.add(Restrictions.eq("admissionNo", admissionNo))
					.add(Restrictions.eq("studentStatus",studentStatus)));
			Student student=(Student)studentCriteria.uniqueResult();
			if (student == null) {
				//logging
			} else {
				//logging
			}
			return student;
		} catch (Exception re) {
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsByClassAndSection(Class clazz,Section section) {
		try {
			Criteria studentCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			studentCriteria.add(Restrictions.conjunction().add(Restrictions.eq("studentClass", clazz))
					  .add(Restrictions.eq("section", section)));
			 List<Student> students=studentCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students;
		} catch (Exception re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsByClassSectionAndSpecialCategory(Class clazz,Section section,SpecialCategory specialCategory) {
		try {
			Criteria studentCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			studentCriteria.add(Restrictions.conjunction().add(Restrictions.eq("studentClass", clazz))
					  .add(Restrictions.eq("section", section))
					  .add(Restrictions.eq("specialCategory", specialCategory)));
		    List<Student> students=studentCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students;
		} catch (Exception re) {
			throw re;
		}
	}
		
	public Student getStudentsByClassSectionAndAdmissionNo(Class clazz,Section section, String admissionNo) {
		try {
			Criteria studentCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			studentCriteria.add(Restrictions.conjunction().add(Restrictions.eq("studentClass", clazz))
					  .add(Restrictions.eq("section", section))
					  .add(Restrictions.eq("admissionNo", admissionNo)));
			Student student=(Student)studentCriteria.uniqueResult();
				if (student == null) {
					//logging
				} else {
					//logging
				}
				return student;
		} catch (Exception re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaleStudentCountInSpecialCategory(SpecialCategory specialCategory){
		try {
			Criteria specialCategoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			specialCategoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("specialCategory", specialCategory))
					  .add(Restrictions.eq("sex","Male")));
			 List<Student> students=specialCategoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer getFemaleStudentCountInSpecialCategory(SpecialCategory specialCategory){
		try {
			Criteria specialCategoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			specialCategoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("specialCategory", specialCategory))
					  .add(Restrictions.eq("sex","Female")));
			 List<Student> students=specialCategoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer getOtherStudentCountInSpecialCategory(SpecialCategory specialCategory){
		try {
			Criteria specialCategoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			specialCategoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("specialCategory", specialCategory))
					  .add(Restrictions.eq("sex","Others")));
			 List<Student> students=specialCategoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public Integer getFemaleStudentCountInCategory(Category category){
		try {
			Criteria categoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			categoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("category", category))
					  .add(Restrictions.eq("sex","Female")));
			 List<Student> students=categoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer getMaleStudentCountInCategory(Category category){
		try {
			Criteria categoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			categoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("category", category))
					  .add(Restrictions.eq("sex","Male")));
			 List<Student> students=categoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer getOtherStudentCountInCategory(Category category){
		try {
			Criteria categoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			categoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("category", category))
					  .add(Restrictions.eq("sex","Others")));
			 List<Student> students=categoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Integer getMaleStudentCountInClass(Class classes){
		try {
			Criteria categoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			categoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("studentClass", classes))
					  .add(Restrictions.eq("sex","Male")));
			 List<Student> students=categoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Integer getFemaleStudentCountInClass(Class classes){
		try {
			Criteria categoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			categoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("studentClass", classes))
					  .add(Restrictions.eq("sex","Female")));
			 List<Student> students=categoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public Integer getOtherStudentCountInClass(Class classes){
		try {
			Criteria categoryCriteria=sessionFactory.getCurrentSession().createCriteria(Student.class);
			categoryCriteria.add(Restrictions.conjunction().add(Restrictions.eq("studentClass", classes))
					  .add(Restrictions.eq("sex","Others")));
			 List<Student> students=categoryCriteria.list();
				if (students == null) {
					//logging
				} else {
					//logging
				}
				return students.size();
         } catch (RuntimeException re) {
			throw re;
		}
	}
}
