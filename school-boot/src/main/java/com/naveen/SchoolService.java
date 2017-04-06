package com.naveen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/rest/school")
class SchoolService {
	private static Logger log = LoggerFactory.getLogger(SchoolService.class);
	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@RequestMapping(value = "/student/{id}")
	public Student getStudent(@PathVariable String id) throws Exception {

		Student student;
		String url = null;

		// via edge server Ribbon(LoadBalancer)
		ServiceInstance edgeServer = loadBalancer.choose("EDGE-SERVER");
		if (edgeServer != null) {
			url = "http://" + edgeServer.getHost() + ":" + edgeServer.getPort() + "/student-service/rest/student/" + id;
			log.info("Edge Server discovered, calling stdent service via proxy");

		} else {
			// direct calling
			ServiceInstance stdInstance = loadBalancer.choose("STUDENT-SERVICE");
			log.info("Edge Server not discovered, calling stdent service  directly");

			if (stdInstance != null) {
				url = "http://" + stdInstance.getHost() + ":" + stdInstance.getPort() + "/rest/student/" + id;
			} else {
				throw new Exception("STUDENT-SERVICE  not found");
			}
		}
		if (url != null) {
			RestTemplate template = new RestTemplate();
			student = template.getForObject(url, Student.class);
		} else {
			throw new Exception("Bad Url");
		}
		return student;
	}

	@RequestMapping("/service-instances/{applicationName}")
	public InstanceInfo serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.eurekaClient.getNextServerFromEureka(applicationName, false);
	}
}