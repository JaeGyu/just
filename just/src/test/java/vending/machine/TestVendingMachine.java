package vending.machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVendingMachine {
	
	/*
	 * 자판기 
	 * 메뉴 
	 * 1. 비타500 800원 
	 * 2. 맥스웰  700원 
	 * 3. 파워에이드 1000원 
	 * 4. 게토레이드 1200원 
	 * 5. 삼다수 800원
	 * 
	 * 불량 돈을 넣으면 뱉어냄
	 * 돈이 투입되면 구입 할 수 있는 음료수들을 알 수 있음
	 * 재고가 있을 경우에만 위의 요구사항이 됨
	 * 재고가 없는 음료수는 재고 없음으로 표시됨
	 * 거스름 반환 레버를 돌리면 투입한 돈과 남아 있는 돈은 반환 됨
	 * 
	 * 돈은 10000원 이상은 투입 못함(이상한 돈으로 분류 됨)
	 * 
	 * */	
	@Test
	public void test() throws Exception {
		
	}
	
	/*
	 * 테스트 시나리오
	 * 1. vm에 음료수를 추가한다.
	 * 2. 위에서 추가한 음료수가 vm에 적재 되었는지 조회 해본다.
	 * */
	@Test
	public void testVendingMachine() throws Exception{
		VendingMachine vm = new VendingMachine();
	}
}
