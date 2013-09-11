/**
 * 
 */
package pagecode;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.portlet.PortletRequest;

import model.Member;
import model.Process;
import dao.MemberDao;
import dao.ProcessDao;

/**
 * @author Plansis
 *
 */
public class ColaboradorEdit extends PageCodeBase {
	private List<Member> members = new ArrayList<Member>();
	private Process process = new Process();
	private List<Process> listProcess = new ArrayList<Process>();
	private String membroValue;
		
	public String addProcess() {
		System.out.println("#AddProcess > muid: " + getMembroValue());
		
		Member m = new MemberDao().getMember(getMembroValue());
		process.setMember(m);		
		new ProcessDao().setProcess(process);		
		return "OK";
	}
	
	public List<Member> getMembers(){
		if(members != null){
			ExternalContext context = getFacesContext().getExternalContext();			
			new MemberDao().setMembers((PortletRequest) context.getRequest());		
			members = new MemberDao().getMembers();
		}
		return members;
	}
	
	public List<Process> getListProcess(){
		if(listProcess != null){
			listProcess = new ProcessDao().getProcess();
		}
		return listProcess;
	}
	
	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public String getMembroValue() {
		return membroValue;
	}

	public void setMembroValue(String membroValue) {
		this.membroValue = membroValue;
	}

	/**
	 * Component's Page
	 */
	protected HtmlForm frmProcess;
	protected HtmlSelectOneMenu membros;
	protected HtmlInputText processo;
	protected HtmlInputText descricao;

	protected HtmlForm getFrmProcess() {
		if (frmProcess == null) {
			frmProcess = (HtmlForm) findComponentInRoot("frmProcess");
		}
		return frmProcess;
	}

	protected HtmlSelectOneMenu getMembros() {
		if (membros == null) {
			membros = (HtmlSelectOneMenu) findComponentInRoot("membros");
		}
		return membros;
	}

	protected HtmlInputText getProcesso() {
		if (processo == null) {
			processo = (HtmlInputText) findComponentInRoot("processo");
		}
		return processo;
	}

	protected HtmlInputText getDescricao() {
		if (descricao == null) {
			descricao = (HtmlInputText) findComponentInRoot("descricao");
		}
		return descricao;
	}



}