package net.classnotfound.demo.kalkulathor.rest;

import lombok.Builder;
import lombok.Data;
import net.classnotfound.demo.kalkulathor.operation.Oper;

@Data
@Builder
public class Calculation {
	private int a;
	
	private int b;
	
	private Oper oper;
	
	
}
