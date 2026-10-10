class Member {
    private String memberName;
    private int membershipId;
    private double feesPaid;

    public Member(String memberName, int membershipId, double feesPaid) {
        this.memberName = memberName;
        this.membershipId = membershipId;
        this.feesPaid = feesPaid;
    }

    public void payFees(double amount) {
        if (amount > 0) {
            feesPaid += amount;
            System.out.println(amount + " paid. Total fees paid: " + feesPaid);
        } else {
            System.out.println("Invalid amount!!");
        }
    }

    public void showMemberDetails() {
        System.out.println("Name: " + memberName);
        System.out.println("Membership ID: " + membershipId);
        System.out.println("Fees Paid: " + feesPaid);
    }
}

public class MemberDemoMain {
    public static void main(String[] args) {
        Member m1 = new Member("Rahul", 101, 500.0);

        System.out.println("--- Before ---");
        m1.showMemberDetails();

        m1.payFees(200);    // valid
        m1.payFees(-50);    // invalid

        System.out.println("--- After ---");
        m1.showMemberDetails();
    }
}