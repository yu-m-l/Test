package YunMusic.test.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import YunMusic.VO.userlist;
import YunMusic.factory.ServiceFactory;
import junit.framework.TestCase;

import java.util.Random;

/**
 * ���ݿ��������������
 * @author MG
 * @version 1.0
 */
public class AddSql {
	
	private static String firstPass = "abcdefghijklmnopqrstuvwxyz";
	private static String lastPass="1234567890";
    private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
    private static String lastName="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼��ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";

    /**
     * �����������
     * @param start ��ʼ��
     * @param end �յ���
     * @return �������ɵ��������
     */
    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    
    /**
     * �����˺���Ϣ
     * @return �������ɵ��˺�����
     */
    public static String getName() {
    	int index=getNum(0, firstName.length()-1);
        String first=firstName.substring(index, index+1);
        index=getNum(0, lastName.length()-1);
        String second=lastName.substring(index, index+1);
        int hasThird=getNum(0,1);
        String third="";
        if(hasThird==1){
            index=getNum(0,lastName.length()-1);
            third=lastName.substring(index, index+1);
        }
        return first+second+third;
    }

    /**
     * ��������
     * @return �������ɵ�����
     */
    public static String getPass() {
    	int index=0;
    	String first="";
    	String second="";
        for(int i=0;i<3;i++) {
        	index=getNum(0, firstPass.length()-1);
            first+=firstPass.substring(index, index+1);
        	index=getNum(0, lastPass.length()-1);
            second+=lastPass.substring(index, index+1);
        }
        
        int hasThird=getNum(0,4);
        int hasFouth=getNum(0,4);
        String third="";
        String fouth="";
        for(int i=0;i<hasFouth;i++){
            index=getNum(0,firstPass.length()-1);
            fouth=firstPass.substring(index, index+1);
        }
        for(int i=0;i<hasThird;i++){
        	index=getNum(0,lastPass.length()-1);
            third=lastPass.substring(index, index+1);
        }
        return first+second+fouth+third;
    }
    
    /**
     * ����qq��
     * @return �������ɵ�qq
     */
    public static String getQqname() {//qq��7-11λ
    	String first="";
    	int index=0;
    	for(int i=0;i<7;i++) {
    		index=getNum(0,lastPass.length()-1);
    		first+=lastPass.substring(index,index+1);
    	}
    	int hashThird=getNum(0,4);
    	String second="";
		for(int i=0;i<hashThird;i++) {
			index=getNum(0,lastPass.length()-1);
    		second+=lastPass.substring(index,index+1);
		}
    	return first+second;
    }
}
