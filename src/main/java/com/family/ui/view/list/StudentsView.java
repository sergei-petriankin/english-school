package com.family.ui.view.list;

import com.family.backend.entity.Student;
import com.family.backend.service.StudentService;
import com.family.ui.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Students | Family English")
public class StudentsView extends VerticalLayout {

    private StudentService studentService;

    private Grid<Student> grid = new Grid<>(Student.class);
    private TextField filterText = new TextField();

    public StudentsView(StudentService studentService) {
        this.studentService = studentService;
        addClassName("list-view");
        setSizeFull();

        configureGrid();
        Div content = new Div(grid);
        content.addClassName("content");
        content.setSizeFull();

        // Adds the content layout to the main layout.
        add(getToolbar(), content);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();

        grid.setColumns("firstName", "lastName");
    }

    private void updateList() {
        grid.setItems(studentService.findAll(filterText.getValue()));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());
        HorizontalLayout toolbar = new HorizontalLayout(filterText);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
