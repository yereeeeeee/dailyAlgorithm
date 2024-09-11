T = int(input())
 
for test_case in range(1, T + 1):
    
    num = int(input())
    a = list(map(int, input().split()))
        
    ct_dict = {}
    for i in a:
        ct_dict[i] = a.count(i)
    
    a = [k for k, v in ct_dict.items() if v == max(ct_dict.values())]
    
    print( "#", num, ' ', a, sep='')