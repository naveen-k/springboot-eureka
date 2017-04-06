package com.naveen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/rest/school")
class SchoolService {

	@Autowired
	private EurekaClient eurekaClient;

	@RequestMapping(value = "/student/{id}")
	public Student getStudent(@PathVariable String id) throws Exception {

		Student student;
		// Get all ServiceInstances associated with a serviceId
		// 'STUDENT-SERVICE'
		InstanceInfo studentService = serviceInstancesByApplicationName("STUDENT-SERVICE");
		if (studentService != null) {
			String url = "http://"+studentService.getHostName()+":"+studentService.getPort()+ "/rest/student/" + id;
			RestTemplate template = new RestTemplate();
			student = template.getForObject(url, Student.class);
		} else {
			throw new Exception("STUDENT-SERVICE  not found");
		}
		return student;
	}

	@RequestMapping("/service-instances/{applicationName}")
	public InstanceInfo serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.eurekaClient.getNextServerFromEureka(applicationName, false);
	}
}