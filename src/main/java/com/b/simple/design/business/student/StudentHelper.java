package com.b.simple.design.business.student;
public class StudentHelper {

	public static final int GRADE_B_LOWER_LIMIT = 51;
	public static final int GRADE_B_UPPER_LIMIT = 80;
	public static final int EXTRA_RANGE_FOR_MATH = 10;
	public static final int GRADE_A_LOWER_LIMIT = 91;
	public static final int EXTRA_FOR_MATH = 5;
	public static final int LOWER_LIMIT_FOR_QUIZ = 20;
	public static final int UPPER_LIMIT_FOR_QUIZ = 80;

	/* PROBLEM 1 */
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	public boolean isGradeB(int marks, boolean isMaths) {
		int extraLimitGradeB = isMaths ? EXTRA_RANGE_FOR_MATH : 0;

		int gradeBUpperLimit = GRADE_B_UPPER_LIMIT + extraLimitGradeB;

		return marks>= GRADE_B_LOWER_LIMIT && marks<= gradeBUpperLimit;
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {
		int extraLimit = isMaths ? EXTRA_FOR_MATH : 0;

		if (mark >= (GRADE_A_LOWER_LIMIT + extraLimit))
			return Grade.A.toString();

		if (mark >= GRADE_B_LOWER_LIMIT + extraLimit)
			return Grade.B.toString();
		return Grade.C.toString();
	}

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */
        
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
		int extraNeededMarks = isMaths ? EXTRA_FOR_MATH : 0;

		if (isNotGood(marks1, extraNeededMarks) || isNotGood(marks2, extraNeededMarks))
			return "NO";

        if (isGood(marks1, extraNeededMarks) || isGood(marks2, extraNeededMarks))
			return "YES";

        return "MAYBE";
    }

	private boolean isGood(int marks, int extraNeededMarks) {
		return marks >= UPPER_LIMIT_FOR_QUIZ + extraNeededMarks;
	}

	private boolean isNotGood(int marks, int extraNeededMarks) {
		return marks <= LOWER_LIMIT_FOR_QUIZ + extraNeededMarks;
	}

}