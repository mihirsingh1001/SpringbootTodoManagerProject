package com.mihirsingh.todomanager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

	@Id
	@Column(name = "id")
	private int todoId;
	@Column(name = "message")
	private String todoMessage;
	@Column(name = "status")
	private String status;

	public Todo(int todoId, String todoMessage, String status) {
		super();
		this.todoId = todoId;
		this.todoMessage = todoMessage;
		this.status = status;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoMessage() {
		return todoMessage;
	}

	public void setTodoMessage(String todoMessage) {
		this.todoMessage = todoMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoMessage=" + todoMessage + ", status=" + status + "]";
	}

}
