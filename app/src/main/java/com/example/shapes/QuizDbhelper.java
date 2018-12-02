package com.example.shapes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shapes.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Focus.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct", "A", "B", "C", 1);
        addQuestion(q1);
        Question q2 = new Question("B is correct", "A", "B", "C", 2);
        addQuestion(q2);
        Question q3 = new Question("C is correct", "A", "B", "C", 3);
        addQuestion(q3);
        Question q4 = new Question("B is correct again", "A", "B", "C", 2);
        addQuestion(q4);
        Question q5 = new Question("A is correct again", "A", "B", "C", 1);
        addQuestion(q5);
        Question q6 = new Question("B is correct again", "A", "B", "C", 2);
        addQuestion(q6);
        Question q7 = new Question("C is correct again", "A", "B", "C", 3);
        addQuestion(q7);
        Question q8 = new Question("B is correct", "A", "B", "C", 2);
        addQuestion(q8);
        Question q9 = new Question("A is correct", "A", "B", "C", 1);
        addQuestion(q9);
        Question q10 = new Question("C is correct", "A", "B", "C", 3);
        addQuestion(q10);
        Question q11 = new Question("C is correct", "A", "B", "C", 3);
        addQuestion(q11);
        Question q12 = new Question("B is correct", "A", "B", "C", 2);
        addQuestion(q12);
        Question q13 = new Question("A is correct", "A", "B", "C", 1);
        addQuestion(q13);
        Question q14 = new Question("B is correct", "A", "B", "C", 2);
        addQuestion(q14);
        Question q15 = new Question("C is correct", "A", "B", "C", 3);
        addQuestion(q15);

    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);


    }

}
