package net.classnotfound.demo.kalkulathor.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.classnotfound.demo.kalkulathor.operation.Div;
import net.classnotfound.demo.kalkulathor.operation.Operation;
import net.classnotfound.demo.kalkulathor.operation.Plus;
import net.classnotfound.demo.kalkulathor.operation.Time;

@RestController
@RequestMapping("/api")
public class KalkController {
	
	@GetMapping("/calculate")
	public long calculate(@RequestBody Calculation calc) {
		Operation operation;
		switch (calc.getOper()) { 
			case DIV: operation = new Div();
			case SUB: operation =  new Time();
			case TIME: operation =  new Time();
			default:  operation =  new Plus();
		}
		return operation.calculate(calc.getA(), calc.getB());
		
	}
}
