package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Reservation reservation = new Reservation();

		System.out.print("Room number: ");
		int roomNumber = read.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(read.next());
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(read.next());

		if (!checkOut.after(checkIn)) { // after = testa se a date e depois da outra
			System.out.println("Erro in reservation: Check-out date must be after check-in date");
		} else {
			reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (DD/MM/YYYY): ");
		checkIn = sdf.parse(read.next());
		System.out.print("Check-in date (DD/MM/YYYY): ");
		checkOut = sdf.parse(read.next());

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) { // testa se a date e antes da outra
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		}

		else if (!checkOut.after(checkIn)) {
			System.out.println("Erro in reservation: Check-out date must be after check-in date");
		} else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		read.close();

	}
}
