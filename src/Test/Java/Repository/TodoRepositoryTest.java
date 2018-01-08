package Repository;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import springboot.model.Todo;
import springboot.model.constants.TodoPriority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoRepositoryTest {

    @Mock
    List<Todo> todoList= new ArrayList<Todo>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void setDown(){
        Mockito.verifyNoMoreInteractions(todoList);
    }

    @Test
    public void storeTest(){

        Todo todo = new Todo("Makan", TodoPriority.MEDIUM);
        boolean isTrue = true;

        BDDMockito.given(todoList.add(todo)).willReturn(isTrue);

        isTrue = todoList.add(todo);

        Assert.assertTrue(isTrue);

        BDDMockito.then(todoList).should().add(todo);
    }

    /**
     * fungsi getAll tidak perlu dibuat unit test karena fungsi ini tidak memanggil fungsi lain
     */
}
