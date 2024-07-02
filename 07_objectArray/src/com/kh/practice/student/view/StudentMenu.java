package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {

	StudentController controller = new StudentController();
	
	// 멤버 필드
	public StudentMenu() {
		System.out.println("========== 학생 정보 출력 ==========");
		
		
		for(Student student : controller.printStudent()) {
			System.out.printf(student.inform());
		}
		
		// StudentController에 printStudent()의 반환 값을 통해 학생 정보 출력
		
		
		System.out.println("========== 학생 성적 출력 ==========");
		System.out.println("학생점수 합계 : " + (int)controller.avgScore()[0]);
		System.out.println("학생점수 평균 : " + controller.avgScore()[1]);
		// StudentController에 avgScore()를 통해 점수 합계와 평균 출력
		//========== 성적 결과 출력 ==========
		
		for() {
			System.out.println(student.getName()+"학생은 " + result +"입니다.");
		}
		// 학생의 점수가 CUT_LINE 미만이면 재시험 대상, 이상이면 통과 출력
		
	}
}
