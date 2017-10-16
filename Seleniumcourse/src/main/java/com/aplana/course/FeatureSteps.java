package com.aplana.course;

import com.aplana.course.steps.StepHolder;
import cucumber.api.DataTable;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class FeatureSteps {

    private static StepHolder stepHolder = new StepHolder();

    @Дано("^загружена \"([^\"]*)\" страница$")
    public void открывается_страница(String pageName) throws Throwable {
        stepHolder.loadPage(pageName);
    }

    @Тогда("^открыта \"([^\"]*)\" страница$")
    public void открыта_страница(String pageName) throws Throwable {
        stepHolder.isPageOpen(pageName);
    }

    @Когда("^выполнено нажитие на поле \"([^\"]*)\"$")
    public void выполнено_нажитие_на(String fieldName) throws Throwable {
        stepHolder.clickOn(fieldName);
    }

    @Когда ("^поле \"([^\"]*)\" заполняется значением \"([^\"]*)\"$")
    public void заполнение_поля_значением(String fieldName, String value){
        stepHolder.fillField(fieldName, value);
    }
    @Когда("^выбирается чекбоксы для \"([^\"]*)\":$")
    public void выбираются_производители(String selection, DataTable plants){
        stepHolder.selectCheckbox(selection, plants.asList(String.class));
    }

    @Когда("^количество найденных элементов \"([^\"]*)\"$")
    public void количество_найденных(int count){
        stepHolder.isSearchResultNumber(count);
    }

    @Когда("^сохранено значение \"([^\"]*)\" элемента из найденных в переменную \"([^\"]*)\"$")
    public void сохранен_элемент(int index, String variableName){
        stepHolder.saveElement(index, variableName);
    }

    @Когда("^поиск элемента \"([^\"]*)\"$")
    public void поиск_элемента(String variableName){
        stepHolder.searchElement(variableName);
    }

    @Когда("^получен \"([^\"]*)\" результат$")
    public void ожидаемый_результат(String vareableName){
        stepHolder.compareResult(vareableName);
    }
}
