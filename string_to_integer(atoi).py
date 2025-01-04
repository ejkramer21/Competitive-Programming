class string_to_integer(atoi):
    def myAtoi(self, s: str) -> int:
        s=s.strip()

        ans=0
        neg=False
        for i,car in enumerate(s):
            if (i==0 and (car=='+' or car=='-')):
                if car=='-':
                    neg=True
                continue
            elif not car.isdigit():
                break

            ans*=10
            ans+=int(car)

        if ans> 2**31-1 and neg:
            ans=2**31
        elif ans>2**31-1:
            ans=2**31-1
        return -ans if neg else ans