   break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    myAccount.depositMoney(depositAmount);
                    break;

                case 3:
                    System.out.println("Available Balance: Rs " + myAccount.viewBalance());
                    break;

                case 4:
                    System.out.println("Session ended. Have a great day!");
                    break;
