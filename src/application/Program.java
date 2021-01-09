package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = read.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(read.next());
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(read.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(read.next());
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkOut = sdf.parse(read.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		} catch (ParseException e) {
			System.out.println("Invalid format");
		} catch (DomainException e) {
			System.out.println("Erro in reservation: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		read.close();

	}
}
