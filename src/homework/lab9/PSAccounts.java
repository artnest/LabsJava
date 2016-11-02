package homework.lab9;

public class PSAccounts {
    public static void main(String[] args) {
        try {
            if (args.length >= 1) {
                if (args[0].equals("-?") || args[0].equals("-h")) {
                    System.out.println(
                            "Syntax:\n" +
                                    "\t-a   [file [encoding]] - append data\n" +
                                    "\t-az  [file [encoding]] - append data, compress every record\n" +
                                    "\t-d                     - clear all data\n" +
                                    "\t-dk  {h|a|o|d} key     - clear data by key\n" +
                                    "\t-p                     - print data unsorted\n" +
                                    "\t-ps  {h|a|o|d}         - print sorted by numberHouse/" +
                                                                                "numberApartment/" +
                                                                                "owner/" +
                                                                                "paymentDate\n" +
                                    "\t-psr {h|a|o|d}         - print data reverse sorted by numberHouse/" +
                                                                                            "numberApartment/" +
                                                                                            "owner/" +
                                                                                            "paymentDate\n" +
                                    "\t-f   {h|a|o|d}         - find records by key\n" +
                                    "\t-fr  {h|a|o|d}         - find records > key\n" +
                                    "\t-fl  {h|a|o|d}         - find records < key\n" +
                                    "\t-?, -h                 - command line syntax\n"
                    );
                } else if (args[0].equals("-a")) {
                    appendFile(args, false);
                } else if (args[0].equals("-az")) {
                    appendFile(args, true;
                } else if (args[0].equals("-p")) {
                    printFile();
                } else if (args[0].equals("-ps")) {
                    if (!printFile(args, false)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-psr")) {
                    if (!printFile(args, true)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-d")) {
                    if (args.length != 1) {
                        System.err.println("Invalid number of arguments");
                        System.exit(1);
                    }

                    deleteFile();
                } else if (args[0].equals("-dk")) {
                    if (!deleteFile(args)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-f")) {
                    if (!findByKey(args)) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-fr")) {
                    if (!findByKey(args, new KeyComparators.KeyComparator())) {
                        System.exit(1);
                    }
                } else if (args[0].equals("-fl")) {
                    if (!findByKey(args, new KeyComparators.KeyComparatorReverse())) {
                        System.exit(1);
                    }
                } else {
                    System.err.println("Option isn't realized: " + args[0]);
                    System.exit(1);
                }
            } else {
                System.err.println("PublicServicesAccounts: Nothing to do! Enter -? for options.");
            }
        } catch (Exception e) {
            System.err.println("Runtime error: " + e);
            System.exit(1);
        }

        System.out.println("PublicServicesAccount finished...");
        System.exit(0);
    }
}
