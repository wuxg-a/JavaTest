package com.wxg.bean.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;


public class BeanCopy {

	public static void main(String[] args) {
		
		//testJava8Lambda();
		//testMember();
		testDepartment();
		//testJava8Sorted();
	}	
	
	private static void testJava8Sorted(){
		List<String> list = new ArrayList<String>(Arrays.asList("3","4","6","1"));
//		List<String> list2 = list.stream().sorted((s1, s2) -> {
//			return s1.compareTo(s2);
//		}).collect(Collectors.<String> toList());
//		System.out.println();
	}
	
	@SuppressWarnings("unused")
	private static void testJava8Lambda(){
		List<Member> list = new ArrayList<>();
		Date dt=new Date();
		Member bean1 = new Member("1","u1","o1","wxg1","t1",(byte)1,(byte)1,"creatorId1",dt,false);
		Member bean2 = new Member("2","u2","o2","wxg1","t1",(byte)2,(byte)2,"creatorId2",dt,false);
		Member bean3 = new Member("3","u3","o3","wxg1","t1",(byte)3,(byte)3,"creatorId3",dt,false);
		Member bean4 = new Member("4","u4","o4","wxg1","t1",(byte)4,(byte)4,"creatorId4",dt,false);
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		list.add(bean4);
		
//		list.stream().filter(m -> isGreaterThan(m.getId() , 2)).forEach(m-> addStr(m,"hello"));
		System.out.println();
	}
	
	
	public static void testMember(){
		Date dt=new Date();
		List<Member> list = new ArrayList<>();
		Member bean1 = new Member("1","u1","o1","wxg1","t1",(byte)1,(byte)1,"creatorId1",dt,false);
		Member bean2 = new Member("2","u2","o2","wxg1","t1",(byte)2,(byte)2,"creatorId2",dt,false);
		Member bean3 = new Member("3","u3","o3","wxg1","t1",(byte)3,(byte)3,"creatorId3",dt,false);
		Member bean4 = new Member("4","u4","o4","wxg1","t1",(byte)4,(byte)4,"creatorId4",dt,false);
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		list.add(bean4);
		List<MemberVO> list2 = toMemberVOList(list);
		System.out.println(list2.size());
	}
	public static void testDepartment(){
		Date dt=new Date();
		List<Department> list = new ArrayList<>();
		Department bean1 = new Department("1","wxg1","p1",(double)1,"orgId1","creatorId1",dt);
		Department bean2 = new Department("2","wxg2","p2",(double)2,"orgId2","creatorId2",dt);
		Department bean3 = new Department("3","wxg3","p3",(double)3,"orgId3","creatorId3",dt);
		Department bean4 = new Department("4","wxg4","p4",null,"orgId4","creatorId4",dt);
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		list.add(bean4);
		List<DepartmentVO> list2 = toDepartmentVOList(list);
		System.out.println(list2.size());
	}
	
	public static MemberVO toMemberVO(Member member){
		if(member == null){
			return null;
		}
		MemberVO memberVO = new MemberVO();
		BeanUtils.copyProperties(member, memberVO);
		
		return memberVO;
	}
	
	public static List<MemberVO> toMemberVOList(List<Member> memberList){ 
		if(memberList == null){
			return null;
		}
		List<MemberVO> memberVOList = new ArrayList<MemberVO>(memberList.size());
//		memberVOList = memberList.stream().map(new Function<Member,MemberVO>(){
//			@Override
//			public MemberVO apply(Member t) {
//
//				return toMemberVO(t);
//
//			}
//		}).collect(Collectors.<MemberVO> toList());
		
		return memberVOList;
	}
	
	public static DepartmentVO toDepartmentVO(Department department){
		if(department == null){
			return null;
		}
		DepartmentVO departmentVO = new DepartmentVO();
		BeanUtils.copyProperties(department, departmentVO);
		return departmentVO;
	}
	
	public static List<DepartmentVO> toDepartmentVOList(List<Department> departmentList){
		if(departmentList == null){
			return null;
		}
//		List<DepartmentVO> departmentVOList = departmentList.stream()
//				.map(department -> toDepartmentVO(department))
//				.collect(Collectors.<DepartmentVO> toList());
		
		return null;
	}
	
	private static void addStr(Member m,String addStr){
		String str = m.getOrgId();
		m.setOrgId(str.concat(addStr));
		
	}
	private static boolean isGreaterThan(String param , int base){
		if(param == null){
			return true;
		}
		int paramInt = Integer.parseInt(param);
		if(paramInt > base)
			return true;
		else
			return false;
	}
}
