package system.command;

import system.IssueSystem;
import system.MainClass;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.behaveImp.DefaultBehavior;

import java.util.Scanner;

public class CreateNewUserCommand implements Command {

	private static class CreateNewUserCommandSingleton {
		private static final CreateNewUserCommand INSTANCE =
			new CreateNewUserCommand();
	}

	public static CreateNewUserCommand getInstance() {
		return CreateNewUserCommandSingleton.INSTANCE;
	}


	@Override
	public void execute() {
		System.out.println("Tworzenie nowego uzytkownika:");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj imię:");
		String name = scanner.nextLine();
		System.out.println("Podaj nazwisko:");
		String surname = scanner.nextLine();
		System.out.println("Podaj Nazwe roli");
		String roleName = scanner.nextLine();
		RoleType roleType = RoleType.valueOf(roleName);
		if(roleType == null) {
			roleType = RoleType.GUEST;
		}


		SimplyUser simplyUser = new SimplyUser(name,
			surname,
			roleType,
			new DefaultBehavior());

		IssueSystem.getInstance().createNewUser(
			MainClass.loggedInUser,
			simplyUser
		);
	}

}
