package com.family.ui.view.list;

import com.family.backend.entity.Student;
import com.family.backend.service.StudentService;
import com.family.ui.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Students | Family English")
public class StudentsView extends VerticalLayout {

    private StudentService studentService;

    private Grid<Student> grid = new Grid<>(Student.class);

    public StudentsView(StudentService studentService) {
        this.studentService = studentService;
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        Div content = new Div(grid);
        content.addClassName("content");
        content.setSizeFull();

        // Adds the content layout to the main layout.
        add(content);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();

        grid.setColumns("firstName", "lastName");
    }

    private void updateList() {
        grid.setItems(studentService.findAll());
    }
}
