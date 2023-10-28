public class VirtualAddress {
    //some update
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java VirtualAddress <virtual_address>");
            return;
        }

        try {
            long virtualAddress = Long.parseLong(args[0]);
            VirtualAddressInfo addressInfo = getVirtualAddressInfo(virtualAddress);

            System.out.println("The address " + virtualAddress + " contains:");
            System.out.println("page number = " + addressInfo.pageNumber);
            System.out.println("offset = " + addressInfo.offset);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid decimal virtual address.");
        }
    }

    private static VirtualAddressInfo getVirtualAddressInfo(long virtualAddress) {
        long pageNumberHelper = 0xFFFFF000L; // page number are the 20bits starting from MSB of the 32 bit address.
        long offsetHelper = 0x00000FFF; // offset are the 12 bits from LSB of the 32 bit address.
        long shiftBit = 12; // helps to shift he 20 bits to LSB to get the answer.


        long pageNumber = (virtualAddress & pageNumberHelper) >> shiftBit;
        int offset = (int) (virtualAddress & offsetHelper);

        return new VirtualAddressInfo(pageNumber, offset);
    }

}
