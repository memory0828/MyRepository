package ch12.exam12;

import java.util.Map;
import java.util.Set;
public class ThreadInfoExample {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setName("AutoSaveThread");
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		//이 아래는 현재 스레드 그룹이 몇개가 있고, 그 그룹에 어떤게 있는지 출력함
		//지금 진도 상태에서는 설명따로 안하고넘어감 나중에 15장하면 이해됨
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			System.out.println("Name: " + thread.getName() + ((thread.isDaemon())?"(데몬)": "(주)"));
			System.out.println("\t" + "소속그룹: " + thread.getThreadGroup().getName());
			System.out.println();
		}
	}
}