package al03_stack_queue;

//정수:0 실수:0.0 논리:false 객체:null
public class IntQueue {
	int capacity; // 큐의 크기
	int queue[]; // 큐의 메모리를 선언
	int front; // 제일 앞 위치
	int rear; // 제일 마지막 위치
	int dataCnt; // 데이터 갯수

	public IntQueue() {

	}

	public IntQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];

		front = 0;
		rear = 0;
		dataCnt = 0;
	}

	// 1.(추가)enqueue: 데이터 추가
	public int enqueue(int data) throws QueueOverFlowException {
		System.out.println("intQueue.enqueue 실행!");
		// 1순위: 데이터가 가득찼는지 확인
		// -> dataCnt: 이놈은 데이터가 추가하고 삭제할때마다 움직임
		if (capacity <= dataCnt) {
			System.out.println("\n오버플로우 발생!");
			// 오버플로우 발생시 메소드종료.
			throw new QueueOverFlowException();
		}
		// 데이터를 큐에 추가하고 rear+1한다.(rear 위치)
		queue[rear++] = data;
		// 데이터의 수가 증가
		dataCnt++;
		// rear 위치를 ring형으로 처리.
		// -> rear가 마지막 위치한다면 다음 rear는 0부터 시작.
		if (rear == capacity) {
			rear = 0;
		}
		// 확인하기
		System.out.println("front: " + front + " rear: " + rear + " 남은 데이터 수: " + dataCnt);
		return data;
	}

	// 2.(삭제)dequeue: 큐에서 데이터 얻어오기
	public int dequeue() throws QueueEmptyException {
		System.out.println("intQueue.dequeue 실행!");
		// 1순위: 데이터가 없는지 확인
		if (dataCnt <= 0) {
			System.out.println("\n언더플로우 발생!");
			throw new QueueEmptyException();
		}
		int deData = queue[front++];
		// 데이터의 수가 감소
		dataCnt--;
		// front 위치를 ring형으로 처리.
		// -> front가 마지막 위치한다면 다음 front는 0부터 시작.
		if (front == capacity) {
			front = 0;
		}
		// 확인하기
		System.out.println("front: " + front + " rear: " + rear + " 남은 데이터 수: " + dataCnt);
		return deData;
	}

	// 3.(확인)peek: 제일앞(front)의 값을 확인
	public void peek() throws QueueEmptyException {
		System.out.println("intQueue.peek 실행!");
		if (dataCnt <= 0) {
			throw new QueueEmptyException();
		}
		System.out.println("제일앞의 값: " + queue[front]);
	}

// 4.(모두확인)info: 큐의크기, 데이터의 수, front인덱스, rear인덱스, 처음값, 마지막값
//	public void info() throws QueueEmptyException {
//		System.out.println("intQueue.info 실행!");
//		if (dataCnt <= 0) {
//			throw new QueueEmptyException();
//		}
//		System.out.println("큐의 크기: " + capacity);
//		System.out.println("데이터의 수: " + dataCnt);
//		System.out.println("현재 front index: " + front);
//		System.out.println("현재 rear index: " + rear);
//		System.out.println("처음값: " + queue[front]);
//		System.out.println("마지막값: " + queue[rear-1]);
//	}

	// 4.(모두확인)info: 큐의크기, 데이터의 수, front인덱스, rear인덱스, 처음값, 마지막값
	// 큐의 크기
	public int getCapacity() {
		return capacity;
	}

	// 큐의 데이터 수
	public int getSize() {
		return dataCnt;
	}

	// front index
	public int getFrontIndex() {
		return front;
	}

	// rear index
	public int getRearIndex() {
		return rear;
	}

	// 처음 값(front)
	public int getFrontData() throws QueueEmptyException
	{
		System.out.println("intQueue.peek 실행!");
		if (dataCnt <= 0) {
			throw new QueueEmptyException();
		}
		return queue[front];
	}

	// 마지막 값(rear)
	public int getRearData() {
		return queue[rear - 1];
	}

	// 언더플로우(데이터가 없을시) 발생시 처리할 예외
	class QueueEmptyException extends RuntimeException {
		public QueueEmptyException() {
		};
	}

	// 오버플로우 발생시 처리할 예외
	class QueueOverFlowException extends RuntimeException {
		QueueOverFlowException() {
		};
	}

}
