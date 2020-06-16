package me.youzhilane.dojo;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        System.out.println("args:"+args[0]);
        System.out.println("args:"+args[1]);
        //System.out.println("args:"+args[2]);
        VirtualMachine vmObj = VirtualMachine.attach(args[0]);//targetJvmPid 为目标 JVM 的进程 ID
        vmObj.loadAgent(args[1], "");  // agentJarPath 为 agent jar 包的路径，cfg 为传递给 agent 的参数
    }
}
