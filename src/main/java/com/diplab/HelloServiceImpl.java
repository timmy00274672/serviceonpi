package com.diplab;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "com.diplab.HelloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		System.out.format("in sayHello: Receive %s ", name);
		return "JAVA-WS " + name;
	}

	public static void main(String[] args) {
		System.out.println("HI");
		Endpoint.publish("http://0.0.0.0:9004/webservice/sayHello",
				new HelloServiceImpl());
	}

	@Override
	public double CO2ppm() {
		return RpiCO2.get();
	}

	@Override
	public void off() {
		RpiTrunLightController.off();
		return;

	}

	@Override
	public void on() {
		RpiTrunLightController.on();
		return;
	}

	@Override
	public void toggle() {
		RpiTrunLightController.toggle();
		return;
	}

	@Override
	public void executeAC() {
		RunLIRC.executeAC();
		return;

	}

}
