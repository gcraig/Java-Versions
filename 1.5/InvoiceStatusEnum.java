public enum InvoiceStatusEnum {

	Open,
	Billed,
	Paid,
	Reprinted,
	PartiallyPaid,
	Collections;
	
	public static void main(String[] args) {

		System.out.println("Testing enum");
		System.out.println(InvoiceStatusEnum.Paid);

        // print enumeration value
		InvoiceStatusEnum is = InvoiceStatusEnum.Open;
		System.out.println(is);
		
		// iterate through enumerations
		for (InvoiceStatusEnum is2 : InvoiceStatusEnum.values()) {
		    System.out.println(is2);
		};
	}
}