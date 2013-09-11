/**
 * 
 */
package pagecode;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.portlet.PortletRequest;

import model.Member;
import model.Process;
import bo.PumaBO;
import dao.ProcessDao;

/**
 * @author Plansis
 *
 */
public class ColaboradorView extends PageCodeBase {
	private List<Process> process = new ArrayList<Process>();
	private Member member = new Member();
	
	public List<Process> getProcess() {
		if (process != null) {
			if (member != null) {
				PumaBO puma = new PumaBO();
				// Get portlet's request
				ExternalContext context = getFacesContext().getExternalContext();
				puma.setPortletRequest((PortletRequest) context.getRequest());
	
				// Get from LDAP the current user
				member = puma.getCurrentUser();
			}
			process = new ProcessDao().getProcess(member.getName());
		}
	
		return process;
	}
	
	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}
	
	public void setProcess(List<Process> process) {
		this.process = process;
	}


}