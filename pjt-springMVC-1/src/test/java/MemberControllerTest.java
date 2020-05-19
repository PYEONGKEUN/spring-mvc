
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.itbuddy.spring1.controller.MemberController;
import org.itbuddy.spring1.domain.CodeLabelValue;
import org.itbuddy.spring1.service.CodeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {
	@InjectMocks
	private MemberController controller;
	@Mock
	private CodeService codeService;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void register() throws Exception{
		   String classCode = "A01";
		   List<CodeLabelValue> jobList = codeService.getCodeList(classCode);
		
		mockMvc.perform(get("/user/register"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("jobList"))
		.andExpect(model().attribute("jobList", jobList));
	}

	
	
}
