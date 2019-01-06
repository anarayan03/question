package pl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import bean.QuestionBean;
import dao.CQuestionDaoImpl;
import service.IQuestionService;
import service.QuestionServiceImpl;

public class QuestionClient 
{
	
	static Scanner scanner = new Scanner(System.in);
	static IQuestionService iQuestionService = null;
	static QuestionServiceImpl questionServiceImpl = null;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException
	{
		int weightage = 0;
		String businessSegment;
		System.out.println(" Enter Business Segment from Business Auto, Apartment, Restaurant, General Merchant");
		businessSegment = scanner.next();
		
		QuestionBean questionBean = null;

		questionBean=new QuestionBean();
		questionServiceImpl=new QuestionServiceImpl();
		List<QuestionBean> list=new ArrayList<>();
		list=questionServiceImpl.getQuestions(businessSegment);
		
		Iterator<QuestionBean> iterator = list.iterator();
		if(list.isEmpty())
		{
			System.out.println("No questions....");
		}else
		{
			boolean itr = true;
			while(itr)
			{
				QuestionBean questionBean1 = new QuestionBean();
				questionBean1 = iterator.next();
				System.out.println(questionBean1.getQuestion()+"?");
				System.out.println("1.	"+questionBean1.getAnswer1());
				System.out.println("2.	"+questionBean1.getAnswer2());
				System.out.println("3.	"+questionBean1.getAnswer3());
				int choice;
				System.out.println("Select your answer");
				choice = scanner.nextInt();
				switch (choice)
				{
				case 1 :
					
					weightage = weightage+questionBean1.getAnswerWeightage1();
					System.out.println(weightage+"\n");
					
					break;

				case 2 :
					
					weightage = weightage+questionBean1.getAnswerWeightage2();
					System.out.println(weightage+"\n");
					
					break;
					
				case 3 :
					
					weightage = weightage+questionBean1.getAnswerWeightage3();
					System.out.println(weightage+"\n");
					
					break;
					
				default:
					
					System.out.println("wrong answer");
					break;
				}
			}
		}
	}
}
